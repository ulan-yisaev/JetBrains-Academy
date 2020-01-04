/*Work on project. Stage 5/6: X-files
Project: Encryption-Decryption*/
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        int shift = 0;
        int i = 0;
        String whatToDo = "enc";
        String dataTxt = "";
        String pathToFileIn = "";
        String pathToFileOut = "";

        for (String arg : args) {
            try {
                switch (arg) {
                case "-mode":
                    whatToDo = args[i + 1];
                    System.out.println("whatToDo = " + whatToDo);
                    break;
                case "-key":
                    shift = Integer.parseInt(args[i + 1]);
                    System.out.println("shift = " + shift);
                    break;
                case "-data":
                    dataTxt = args[i + 1];
                    System.out.println("dataTxt = " + dataTxt);
                    break;
                case "-in":
                    pathToFileIn = args[i + 1];
                    System.out.println("pathToFileIn = " + pathToFileIn);
                    break;
                case "-out":
                    pathToFileOut = args[i + 1];
                    System.out.println("pathToFileOut = " + pathToFileOut);
                    break;
                default:
                    //System.out.println("(Unknown operation:) current switch case is: " + arg);
                    break;
                }
                i++;
            } catch (Exception e) {
                System.out.println("Error: " + e);
                e.printStackTrace();
            }
        }

        if (!dataTxt.isEmpty()) {
            EncryptDecrypt encdec = new EncryptDecrypt(dataTxt, shift, whatToDo, pathToFileOut);
            encdec.chooseMode();
        } else if (!pathToFileIn.isEmpty()) {
            EncryptDecrypt encdec = new EncryptDecrypt(dataTxt, shift, whatToDo, pathToFileIn, pathToFileOut);
            encdec.chooseMode();
        } else {
            EncryptDecrypt encdec = new EncryptDecrypt(dataTxt, shift, whatToDo, pathToFileOut);
            encdec.chooseMode();
        }
    }
}

class EncryptDecrypt {
    String toProcess;
    int shift;
    String whatToDo;
    String pathToFileIn = "";
    String pathToFileOut = "";

    EncryptDecrypt(String toProcess, int shift, String whatToDo, String pathToFileOut) {
        //System.out.println("+++ 1st constructor");
        this.toProcess = toProcess;
        this.shift = shift;
        this.whatToDo = whatToDo;
        this.pathToFileOut = pathToFileOut;
    }

    EncryptDecrypt(String toProcess, int shift, String whatToDo, String pathToFileIn, String pathToFileOut) {
        //System.out.println("+++ 2nd constructor");
        this.toProcess = toProcess;
        this.shift = shift;
        this.whatToDo = whatToDo;
        this.pathToFileIn = pathToFileIn;
        this.pathToFileOut = pathToFileOut;
    }

    void chooseMode() {
        if (whatToDo.contains("dec")) {
            if (pathToFileIn.isEmpty()) {
                getDecryption(toProcess);
            } else {
                File file = new File(pathToFileIn);
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNext()) {
                        getDecryption(scanner.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Error: " + e);
                    e.printStackTrace();
                }
            }
        }     else {
            if (pathToFileIn.isEmpty()) {
                getEncryption(toProcess);
            } else {
                File file = new File(pathToFileIn);
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNext()) {
                        getEncryption(scanner.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Error: " + e);
                    e.printStackTrace();
                }
            }
        }
    }

    void getEncryption(String toProcess) {
        if (pathToFileOut.isEmpty()) {
            for (char c : toProcess.toCharArray()) {
                System.out.print((char) (shift + (int) c));
            }
        }     else {
            try (FileWriter fileWriter = new FileWriter(pathToFileOut, true); //Set true for append mode
                        PrintWriter printWriter = new PrintWriter(fileWriter)) {
                for (char c : toProcess.toCharArray()) {
                    printWriter.print((char) (shift + (int) c));
                }
                printWriter.println();
            } catch (IOException e) {
                System.out.println("Error: " + e);
                e.printStackTrace();
            }
        }
    }

    void getDecryption(String toProcess) {
        if (pathToFileOut.isEmpty()) {
            for (char c : toProcess.toCharArray()) {
                System.out.print((char) ((int) c - shift));
            }
        }   else {
            try (FileWriter fileWriter = new FileWriter(pathToFileOut, true); //Set true for append mode
                        PrintWriter printWriter = new PrintWriter(fileWriter)) {
                for (char c : toProcess.toCharArray()) {
                    printWriter.print((char) ((int) c - shift));
                }
                printWriter.println();
            } catch (Exception e) {
                System.out.println("Error: " + e);
                e.printStackTrace();
            }
        }
    }
}