package control;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

// TOKEN: 2005850524:AAEMkauxU60XGSLOUabyYYMP77Yiq1A-vLs
public class HangedManBotControl extends TelegramLongPollingBot {

	public void onUpdateReceived(Update update) {
		String chatId = update.getMessage().getChatId().toString();
//		 Revisa si el update tiene un mensaje y si el mensaje tiene texto
//		if (update.hasMessage() && update.getMessage().hasText()) {
//		System.out.println(update.getMessage().getText());
//		System.out.println(update.getMessage().getChatId());
//		
//		message.setChatId(update.getMessage().getChatId().toString());
//		message.setText(update.getMessage().getText());
//		try {
//			// Mediante el metodo exetute se envia el mensaje
//			execute(message);
//		} catch (TelegramApiException e) {
//			e.printStackTrace();
//		}
		switch (Events.valueOf(update.getMessage().getText().substring(1))) {
		case startgame:
			SendMessage message = new SendMessage();
			message.setChatId(chatId);
			message.setText("El juego iniciará en breve");
			try {
				execute(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	public String getBotUsername() {
		return "HangedManxdBot";
	}

	@Override
	public String getBotToken() {
		return "2005850524:AAEMkauxU60XGSLOUabyYYMP77Yiq1A-vLs";
	}

}
