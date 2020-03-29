 package application;

import java.util.Arrays;
import java.util.List;

import marytts.signalproc.effects.JetPilotEffect;
import marytts.signalproc.effects.LpcWhisperiserEffect;
import marytts.signalproc.effects.RobotiserEffect;
import marytts.signalproc.effects.StadiumEffect;
import marytts.signalproc.effects.VocalTractLinearScalerEffect;
import marytts.signalproc.effects.VolumeEffect;

public class Main {
	
	/**
	 * The main method from which our application is starting
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Create TextToSpeech
		TextToSpeech tts = new TextToSpeech();
		
		//=========================================================================
		//======================= Print available AUDIO EFFECTS ====================
		//=========================================================================
		
		//Print all the available audio effects
		tts.getAudioEffects().stream().forEach(audioEffect -> {
			System.out.println("-----Name-----");
			System.out.println(audioEffect.getName());
			System.out.println("-----Examples-----");
			System.out.println(audioEffect.getExampleParameters());
			System.out.println("-----Help Text------");
			System.out.println(audioEffect.getHelpText() + "\n\n");
			
		});
		

		tts.getAvailableVoices().stream().forEach(voice -> System.out.println("Voice: " + voice));
		
		// Setting the Current Voice
		tts.setVoice("cmu-rms-hsmm");
		//VocalTractLinearScalerEffect
		VocalTractLinearScalerEffect vocalTractLSE = new VocalTractLinearScalerEffect(); //russian drunk effect
		vocalTractLSE.setParams("amount:70");
		
		//JetPilotEffect
		JetPilotEffect jetPilotEffect = new JetPilotEffect(); //epic fun!!!
		jetPilotEffect.setParams("amount:100");
		
		//RobotiserEffect
		RobotiserEffect robotiserEffect = new RobotiserEffect();
		robotiserEffect.setParams("amount:50");
		
		//StadiumEffect
		StadiumEffect stadiumEffect = new StadiumEffect();
		stadiumEffect.setParams("amount:150");
		
		//LpcWhisperiserEffect
		LpcWhisperiserEffect lpcWhisperiserEffect = new LpcWhisperiserEffect(); //creepy
		lpcWhisperiserEffect.setParams("amount:70");
		
		//VolumeEffect
		VolumeEffect volumeEffect = new VolumeEffect(); //be careful with this i almost got heart attack
		volumeEffect.setParams("amount:0");
		
		//Apply the effects
		//----You can add multiple effects by using the method `getFullEffectAsString()` and + symbol to connect with the other effect that you want
		//----check the example below
		tts.getMarytts().setAudioEffects(stadiumEffect.getFullEffectAsString());// + "+" + stadiumEffect.getFullEffectAsString());
		
		List<String> arrayList = Arrays.asList("hii vivek", "this is a program for text to speech", "cool this will get uploaded in repos");
		
	// SPEAK LIST OF ARRAYS ONCE, TO REPEAT IT MORE THAN ONE TIME PLEASE INCRESE THE CONDITION TO HOW MANY TIMES YOU NEED TO INCREASE IT.
		for (int i = 0; i < 1; i++)
			arrayList.forEach(word -> tts.speak(word, 2.0f, false, true));
		
	}
	
	
}
