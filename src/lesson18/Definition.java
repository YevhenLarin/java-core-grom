package lesson18;

public class Definition {

    private void notifyUsers(String[] userEmails) {

        for (String email : userEmails) {

            //обработка ошибок
            try {
                //send email to user - error
                System.out.println("Email " + email + " was sent");
                //
                //
                //
            } catch (Exception e) {
                //how should I handle exception
                System.out.println("Email " + email + " was not sent");

                //выполняется в любом случае не зависимо try или catch
            } finally {
                //updateStatus
            }


//            } catch (type2) {
//
//            }

                //1
                //2
                //3


        }
    }
}