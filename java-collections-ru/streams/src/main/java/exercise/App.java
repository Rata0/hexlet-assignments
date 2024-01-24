package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static void main(String[] args) {
        String[] emails = {
                "info@gmail.com",
                "info@yandex.ru",
                "mk@host.com",
                "support@hexlet.io",
                "info@hotmail.com",
                "support.yandex.ru@host.com"
        };

        List<String> emailsList = Arrays.asList(emails);
        App.getCountOfFreeEmails(emailsList); // 3
    }

    public static long getCountOfFreeEmails(List<String> emails) {
        List<String> freeDomain = new ArrayList<>(List.of("gmail.com", "yandex.ru", "hotmail.com"));

        return emails.stream()
                .map((email) -> email.split("@")[1])
                .filter((domen) -> freeDomain.contains(domen))
                .count();
    }
}
// END
