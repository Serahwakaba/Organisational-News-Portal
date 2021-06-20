package models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NewsTest {
    News news = new News("Samsung S11+", "Samsung leaks images of the upcoming s11+", 1);

    @Test
    public void getsInstanceOfNews() {
        assertEquals(true,news instanceof News);
    }

    @Test
    public void getsContent() {
        assertEquals("Samsung S11+", news.getContent());
    }

    @Test
    public void getDescription() {
        assertEquals("Samsung leaks images of the upcoming s11+", news.getDescription());
    }

    @Test
    public void getsDepartmentId() {
        assertEquals(1, news.getDepartmentid());
    }

    @Test
    public void setsContent() {
        news.setContent("Samsung S11+");
        assertEquals("Samsung S11+", news.getContent());
    }
    @Test
    public void setsDescription() {
        news.setDescription("Samsung leaks images of the upcoming s11+");
        assertEquals("Samsung leaks images of the upcoming s11+", news.getDescription());
    }
    @Test
    public void setsDepartmentId() {
        news.setDepartmentid(2);
        assertEquals(2, news.getDepartmentid());
    }
    @Test
    public void setId() {
        news.setId(5);
        assertEquals(5, news.getId());
    }
}
