package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("D:\\Восстановлено\\java\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002\\test", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            javaRush.users.add(new User());
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            if(javaRush.equals(loadedObject)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(users.size());
            printWriter.flush();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            for (User user : users) {
                printWriter.println(user.getFirstName());
                printWriter.println(user.getLastName());
                printWriter.println(df.format(user.getBirthDate()));
                printWriter.println(user.isMale());
                printWriter.println(user.getCountry().name());
            }
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            int usersSize = Integer.parseInt(br.readLine());
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            for (int i = 0; i < usersSize ; i++) {
                String firstName = br.readLine();
                String lastName = br.readLine();
                Date birthDate = format.parse(br.readLine());
                boolean isMale = Boolean.parseBoolean(br.readLine());
                String countryName = br.readLine();
                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setBirthDate(birthDate);
                user.setMale(isMale);
                user.setCountry(User.Country.valueOf(countryName));
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
