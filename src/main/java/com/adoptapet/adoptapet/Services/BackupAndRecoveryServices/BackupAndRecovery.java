package com.adoptapet.adoptapet.Services.BackupAndRecoveryServices;

import com.adoptapet.adoptapet.Exceptions.BackupAndRecoveryExceptions.BackupFailedException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;

@Service
public class BackupAndRecovery {
    //Update the following variables to your system's configuration
    private static final String DB_NAME = "mydb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "mostafagalal";
    private static final String BACKUP_PATH = "C:\\Users\\mosta\\Downloads\\adoptapet\\adoptapet\\backup";
    private static final String MYSQL_PATH = "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysql.exe";
    private static final String MYSQLDUMP_PATH = "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump.exe";

    public void backup() {
        try {
            CodeSource codeSource = BackupAndRecovery.class.getProtectionDomain().getCodeSource();
            String executeCmd = "\"" +  MYSQLDUMP_PATH + "\" -u " + DB_USER + " -p" + DB_PASS + " --databases " + DB_NAME + " -r " + getPath(codeSource);

            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete != 0)
                throw new BackupFailedException();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void recover() {
        try {
            CodeSource codeSource = BackupAndRecovery.class.getProtectionDomain().getCodeSource();
            String[] executeCmd = new String[]{"\"" + MYSQL_PATH + "\"", DB_NAME, "-u" + DB_USER, "-p" + DB_PASS, "-e", " source " + getPath(codeSource)};

            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete != 0)
                throw new BackupFailedException();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getPath(CodeSource codeSource) throws URISyntaxException {
        File jarFile = new File(codeSource.getLocation().toURI().getPath());
        String jarDir = jarFile.getParentFile().getPath();

        File folder = new File(BACKUP_PATH);
        folder.mkdir();

        return "\"" + BACKUP_PATH + "\\backup.sql\"";
    }
}