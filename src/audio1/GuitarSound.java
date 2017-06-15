package audio1;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;

public class GuitarSound {
/*
 * Instrument[] i = syn.getDefaultSoundbank().getInstruments();
			MidiChannel[] channels = syn.getChannels();
			
			syn.loadInstrument(i[127]);
			channels[0].noteOn(60, 100);//On channel 0, play note number 60 with velocity 100 
	        channels[1].noteOn(64, 100);
	        channels[2].noteOn(67, 100);
 * */
	public static void main(String[] args) throws MidiUnavailableException {
		Synthesizer s = MidiSystem.getSynthesizer();
		s.open();
		// Soundbank soundbank = s.getDefaultSoundbank();
		Instrument[] instr = s.getAvailableInstruments();
		// s.loadInstrument(instr[100]);
		MidiChannel[] channels = s.getChannels();
		channels[1].programChange(instr[41].getPatch().getProgram());
		channels[1].noteOn(60, 50);
		channels[1].noteOn(67, 100);
		try { Thread.sleep(1000); // wait time in milliseconds to control duration
        } catch( InterruptedException e ) { }
		channels[1].noteOff(60, 10);
		channels[1].noteOn(120, 100);
		// s.close();
	}
	
}
