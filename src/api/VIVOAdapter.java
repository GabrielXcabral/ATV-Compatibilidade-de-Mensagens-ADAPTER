package api;

import model.SMS;

public class VIVOAdapter implements SMSSender{

    private VivoSender vivoSender;

    public VIVOAdapter (VivoSender objvivosender){
        vivoSender = objvivosender;

    }

    @Override
    public boolean sendSMS(SMS sms) {
        try {

            String[] mensagemfracionada = chunkMessage(sms.getTexto(), 120);

            vivoSender.enviarSMS(sms.getOrigem(), sms.getDestino(), sms.getTimestamp(), mensagemfracionada);
            return true;
        }catch (Exception e){
            System.out.println("Mensagem n foi enviada");
            return false;
        }
    }

    private String[] chunkMessage(String message, int chunkSize) {
        int length = message.length();
        int numOfChunks = (int) Math.ceil((double) length / chunkSize);
        String[] chunks = new String[numOfChunks];

        for (int i = 0; i < numOfChunks; i++) {
            int start = i * chunkSize;
            int end = Math.min((i + 1) * chunkSize, length);
            chunks[i] = message.substring(start, end);
        }
        return chunks;
    }
}
