package Television;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TelevisionTest {
    private Television television;
    @BeforeEach
    public void setUp() {
        television = new Television();
        television.powerOn();
    }

    @AfterEach
    public void tearDown(){
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
    public void testTVDecreasesVolumeWhenVolumeIsDecreased(){
        television.increaseVolume();
        assertEquals(2,television.getVolume());
        television.decreaseVolume();
        assertEquals(0,television.getVolume());
    }

    @Test
    public void testTVChangesChannelWhenChannelIsChanged(){
        television.nextChannel();
        assertEquals(2,television.getChannel());
    }

    @Test
    public void testTVChangesChannelWhenChannelIsChangedBack(){
        television.nextChannel();
        television.nextChannel();
        television.prevChannel();
        assertEquals(2,television.getChannel());
    }

    @Test
    public void testThatChannelCantGoLowerThanChannelOne(){
        television.prevChannel();
        assertEquals(1,television.getChannel());
        television.prevChannel();
        assertEquals(1,television.getChannel());

    }

    @Test
    public void testThatChannelCantGoHigherThanChannel21(){
        for (int channel = 0; channel < 30; channel++) {
            television.nextChannel();
        }

        assertEquals(21,television.getChannel());


    }

}