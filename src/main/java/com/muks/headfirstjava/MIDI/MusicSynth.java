package com.muks.headfirstjava.MIDI;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

/**
 * Created by mukthar.ahmed on 10/19/15.
 *
 * MIDI - Musical Instrument Digital Interface
 *
 */
public class MusicSynth {

    public static void playSound() throws MidiUnavailableException {
        Sequencer sequencer = MidiSystem.getSequencer();
        System.out.println("Obtained a sequencer...");

    }

    public static void main(String[] args) throws MidiUnavailableException {
        MusicSynth.playSound();

    }
}
