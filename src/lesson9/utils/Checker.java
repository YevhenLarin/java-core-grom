package lesson9.utils;

public class Checker {
    //public - доступен всем внутри проэкта
    //private - доступен всем внутри класса
    //--------90+%
    //default (package-private) - доступен всем внутри пакета
    //protected - default + наследники класса

    //private
    //default (package-private)
    //protected
    //public

    int companyNamesValidatedCount = 0;


    public boolean checkCompanyName(String companyName) {
//       if (companyName == "Google" || companyName == "Amazon")
//            return false;
//       return true;
        if (companyNamesValidatedCount > 10)
            return false;

        companyNamesValidatedCount++;
        return companyName != "Google" && companyName != "Amazon";

    }
}
