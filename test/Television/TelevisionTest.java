package Television;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TelevisionTest {
    private Television television;
    private ArrayList<Channel> channels;
    @BeforeEach
    public void setUp() {
        television = new Television();
//        channels = new ArrayList<Channel>();
        television.powerOn();
        television.searchForChannels();

    }

    @AfterEach
    public void tearDown(){
        channels.clear();
        television.powerOff();
    }

    @Test
    public void testTVOn_ItTurnsOn(){
        television.powerOn();
        assertTrue(television.isOn);
    }

    @Test
    public void testTVOff_ItTurnsOff(){
        television.powerOff();
        assertFalse(television.isOn);
    }

    @Test
    public void testTVIncreasesVolumeWhenVolumeIsIncreased(){
        television.increaseVolume();
        assertEquals(2,television.getVolume());
    }

    @Test
    public void testTVVolumeCannotExceed100(){
        for (int number = 0; number < 70; number++) {
            television.increaseVolume();
        }
        assertEquals(100,television.getVolume());
    }

    @Test
    public void testTVDecreasesVolumeWhenVolumeIsDecreased(){
        television.increaseVolume();
        assertEquals(2,television.getVolume());
        television.decreaseVolume();
        assertEquals(0,television.getVolume());
    }

    @Test
    public void testTVVolumeCannotGoLowerThan0(){
        for (int number = 0; number < 70; number++) {
            television.decreaseVolume();
        }
        assertEquals(0,television.getVolume());
    }

    @Test
    public void testTVChangesChannelWhenChannelIsChanged(){
        assertEquals("Channel 1",television.nextChannel().toString());
        assertEquals("Channel 2",television.nextChannel().toString());
    }

    @Test
    public void testTVChangesChannelWhenChannelIsChangedBack(){
        television.nextChannel();
        television.nextChannel();
        assertEquals("Channel 1",television.prevChannel().toString());


    }

    @Test
    public void testThatChannelCantGoLowerThanChannelZero(){
        television.prevChannel();
        assertEquals("Channel 0",television.prevChannel().toString());

    }

    @Test
    public void testThatChannelWillNotExceedChannelUpperLimitRange(){
        for (int channel = 0; channel < 55; channel++) {
            television.nextChannel();
        }

        assertEquals("Channel 0",television.nextChannel().toString());


    }

}