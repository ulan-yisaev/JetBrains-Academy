package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {

    //функция считывания данных из файла
    public static String readFile (String filePath){
        File file = new File (filePath);
        StringBuilder data = null;
        data = new StringBuilder();
        try (Scanner in = new Scanner(file)){
            while (in.hasNext()){
                data.append(in.nextLine());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
//        System.out.println(data);
        return data.toString();
    }

    //функция записи в файл
    public static void writeFile (String filePath, String data){
        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file)){
            writer.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String alg = "shift";
        String mode ="enc";
        int key = 0; // ключ для шифровки / дешифровки
        String data = ""; // строка которую де/шифруем
        int  _dataMode = 1; // если есть арг-ты -data и -in, то предпочтение -data; 0 -чтение аргумента, 1 - файла
        int out = 0; // если нет аргумента -out: 0 - вывод в консоль ; 1 - в файл
        String inFilePath = "";
        String outFilePath = "";

        //  int count = 0; // если 0, то не верный ввод команды. вывод сообщения об ошибке
        if (args.length == 0){
            System.out.println("Error no input data");
        }else {
            //поиск ключа
            for (int i = 0; i < args.length; i++) {
                if(args[i].equals("-alg")) {
                    alg = args[i + 1];
                }
                if (args[i].equals("-key")) {
                    key = Integer.parseInt(args[i + 1]);
                }
                if (args[i].equals("-mode")) {
                    mode = args[i + 1];
                }
                if (args[i].equals("-data")) {
                    data = data + args[i + 1];
                    _dataMode = 0; //есть аргумент -data, значит игнорируем чтение из файла
                }
                if (args[i].equals("-in")) {
                    inFilePath += args[i + 1];
                }
                if (args[i].equals("-out")) {
                    outFilePath += args[i + 1];
                    out = 1; //вывод в файл
                }
            }
        }

        if (_dataMode == 1) {
            data = readFile(inFilePath);
        }

        AlgorithmFactory algorithmFactory = new AlgorithmFactory();
        Algorithm algorithm = algorithmFactory.createAlgorithm(alg);

        switch (mode){
            case "enc" : data = algorithm.getEncryption(data, key); break;
            case "dec" : data = algorithm.getDecryption(data, key); break;
        }

        //вывод результата программы в консоль или в файл
        switch (out){
            case 0 : System.out.println(data); break;
            case 1 : writeFile(outFilePath, data); break;
        }
    }
}
