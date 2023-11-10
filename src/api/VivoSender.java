package api;

import java.time.LocalDateTime;

public interface VivoSender {
    void enviarSMS (String origem, String destino, LocalDateTime time, String[] msgs) throws SMSException;
}
