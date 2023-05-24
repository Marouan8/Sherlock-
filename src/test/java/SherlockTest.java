import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class SherlockTest
{
    @Parameterized.Parameters(name = "{index}:{0}")
    public static Collection<Object[]> data() throws IOException
    {
        List<Object[]> data = new ArrayList<>();
        try(InputStream resourceAsStream = SherlockTest.class.getResourceAsStream("false.txt");
            InputStreamReader reader = new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader))
        {
            bufferedReader.lines()
                    .map(line -> new Object[]{line, false})
                    .forEach(data::add);
        }
        try(InputStream resourceAsStream = SherlockTest.class.getResourceAsStream("true.txt");
            InputStreamReader reader = new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader))
        {
            bufferedReader.lines()
                    .map(line -> new Object[]{line, true})
                    .forEach(data::add);
        }
        return data;
    }

    private final String input;
    private final boolean expected;

    public SherlockTest(String input, boolean expected)
    {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test()
    {
        Assert.assertEquals(expected, Sherlock.isValid(input));
    }


}
