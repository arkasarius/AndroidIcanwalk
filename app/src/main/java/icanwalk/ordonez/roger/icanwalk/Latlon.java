package icanwalk.ordonez.roger.icanwalk;

class Latlon {
    /* latitud longitud ( double, double)
     */
    private Double lat;
    private Double lon;

    Latlon(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
