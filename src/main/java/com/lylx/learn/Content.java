import java.util.List;

public class Content {
    /**
     * id : 1
     * name : Unknown
     * songs : [{"id":0,"name":"Rada"},{"id":1,"name":"Olympic Dream"},{"id":2,"name":"The Escapist"}]
     */

    private int id;
    private String name;
    private List<SongsBean> songs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SongsBean> getSongs() {
        return songs;
    }

    public void setSongs(List<SongsBean> songs) {
        this.songs = songs;
    }

    public static class SongsBean {
        /**
         * id : 0
         * name : Rada
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
