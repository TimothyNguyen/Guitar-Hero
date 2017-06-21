package audio;

import java.util.ArrayList;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JComponent;

import instruments.guitar.MusicNote;

public class Audio extends JComponent{

	private ArrayList<MusicNote> chord;
	private int velocity;
	private double duration;
	
	public Audio() {
		
	}
	
	public Audio(ArrayList<MusicNote> chord, int velocity, double duration) {
		this.chord = chord;
		this.velocity = velocity;
		this.duration = duration;
	}
	
	public synchronized void playNote() {
		Synthesizer s;
		try {
			s = MidiSystem.getSynthesizer();
			s.open();
			Instrument[] instr = s.getAvailableInstruments();
			MidiChannel[] channels = s.getChannels();
			channels[0].programChange(instr[0].getPatch().getProgram());
			for(int i = 0; i < chord.size(); i++) {
				channels[0].noteOn(chord.get(i).getNoteValue(), velocity);
			}
			try { Thread.sleep((long) (duration * 500)); // wait time in milliseconds to control duration
	        } catch( InterruptedException e ) { }
			s.close();
		} catch (MidiUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
}
