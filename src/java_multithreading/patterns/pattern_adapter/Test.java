package java_multithreading.patterns.pattern_adapter;

import java.util.HashMap;
import java.util.Map;

/*
Адаптация нескольких интерфейсов
*/

public class Test {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(new IncomeData() {
            @Override
            public String getCountryCode() {
                return "CA";
            }

            @Override
            public String getCompany() {
                return "HashMap LTD.";
            }

            @Override
            public String getContactFirstName() {
                return "Kaisar";
            }

            @Override
            public String getContactLastName() {
                return "Yerdenbekov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 38;
            }

            @Override
            public int getPhoneNumber() {
                return 501234567;
            }
        });

        System.out.println(incomeDataAdapter.getCompanyName());
        System.out.println(incomeDataAdapter.getCountryName());
        System.out.println(incomeDataAdapter.getName());
        System.out.println(incomeDataAdapter.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer, Contact {

        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String originPhoneNumber = String.format("%010d", data.getPhoneNumber());

            String formatedPhoneNumber = null;
            //+38(050)123-45-67
            formatedPhoneNumber = "+" + data.getCountryPhoneCode() + "(" + originPhoneNumber.substring(0, 3) + ")" + originPhoneNumber.substring(3, 6) + "-" + originPhoneNumber.substring(6, 8) + "-" + originPhoneNumber.substring(8, 10);


            return formatedPhoneNumber;
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: Co Ltd.

        String getContactFirstName();   //For example: Name

        String getContactLastName();    //For example: LastName

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: Co Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: LastName, Name

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}
