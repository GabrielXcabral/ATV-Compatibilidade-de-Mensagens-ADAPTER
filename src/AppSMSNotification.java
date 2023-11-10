import api.*;
import model.SMS;

public class AppSMSNotification {

	public static void main(String[] args) {
		SMSSender sender = new TimService();
		
		VivoSender vivoSender = new VivoService();
		SMSSender vivoadapter = new VIVOAdapter(vivoSender);
		
		SMS message = new SMS("83988885544","83988221133","Bom dia. Seu boleto ja esta disponivel para pagamento");
		
		sender.sendSMS(message);
		System.out.println("\n");
		System.out.println("VIVO ADAPTER: " + "\n");
		vivoadapter.sendSMS(message);
		
		
	}
}
