import java.io.*;
import java.nio.file.*;
import java.util.*;

public class PasswordProcessorCurrent{
    public static void main(String[] args) throws InterruptedException {

        PasswordProcessorCurrent PasswordProcessor = new PasswordProcessorCurrent();

        NewThread thread = new NewThread();
        thread.start();
        Thread myThread = new Thread("myThread-Task");
        myThread.start();
        myThread.join();

        if (args.length < 1) {
            System.out.println("Uso: java PasswordProcessorSerial <caminho_do_diretorio>");
            return;
        }

        String directoryPath = args[0]; // Recebe o caminho como argumento

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Erro: Diretório não encontrado ou inválido.");
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null) {
            System.out.println("Erro ao listar arquivos no diretório.");
            return;
        }

        for (File file : files) {
            processFile(file);
        }
    }

    private static class processFile implements Runnable{
        private final File[] files;

        @Override
        public void run() {
           
           
        }
        
    }

    private static void processFile(File file) {
        
    }

    private static String rot13(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result.append((char) (((c - 'a' + 13) % 26) + 'a'));
            } else if (c >= 'A' && c <= 'Z') {
                result.append((char) (((c - 'A' + 13) % 26) + 'A'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    static class NewThread extends Thread{
        
    }


}

