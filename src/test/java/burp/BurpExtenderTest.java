package burp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.OutputStream;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by amarquez on 4/21/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class BurpExtenderTest {
    @InjectMocks
    private BurpExtender burpExtender;

    @Mock
    IBurpExtenderCallbacks burpExtenderCallbacks;

    @Before
    public void setUp() {
        OutputStream stdOut = mock(OutputStream.class);
        OutputStream stdErr = mock(OutputStream.class);
        when(burpExtenderCallbacks.getStdout()).thenReturn(stdOut);
        when(burpExtenderCallbacks.getStderr()).thenReturn(stdErr);
    }

    @Test
    public void testThatExtensionIsRegisteredOk() {
        // Given
        // Extensions is loaded on Burp

        // When
        burpExtender.registerExtenderCallbacks(burpExtenderCallbacks);

        // Then
        verify(burpExtenderCallbacks).setExtensionName(eq(BurpExtender.NAME));
    }

}
