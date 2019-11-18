package API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CURL {

    public String getDataFromApiByNIP(String s) {

        String url = "https://rejestr.io/api/v1/krs?nip=" + s;
        String[] command = {"curl", url, "--header", "Authorization: aded6b22-2002-4d14-9485-82a9fcd22e93"};

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process;

        try {
            process = processBuilder.start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();

        } catch (
                IOException e) {
            e.printStackTrace();
            return "error";
        }
    }


}
