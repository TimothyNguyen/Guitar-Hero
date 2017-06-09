import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

// some tutorial I found - that works?
public class MidiTest {

	public static void main(String[] args) {
		/*
		try {
			Synthesizer midiSynth = MidiSystem.getSynthesizer();
			midiSynth.open();
			//get and load default instrument and channel lists
	        Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
	        MidiChannel[] mChannels = midiSynth.getChannels();

	        midiSynth.loadInstrument(instr[1]);//load an instrument


	        mChannels[0].noteOn(60, 100);//On channel 0, play note number 60 with velocity 100 
	        mChannels[1].noteOn(64, 100);
	        mChannels[2].noteOn(67, 100);
	        try { Thread.sleep(1000); // wait time in milliseconds to control duration
	        } catch( InterruptedException e ) { }
	        // mChannels[0].noteOff(100);//turn of the note
	        
	      } catch (MidiUnavailableException e) {}
	      */
		
		
		
	}
	
}
