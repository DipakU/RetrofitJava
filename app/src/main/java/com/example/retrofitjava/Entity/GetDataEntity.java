package com.example.retrofitjava.Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class GetDataEntity  {

    @SerializedName("results")
    private ArrayList<Results> results;

    @SerializedName("info")
    private Information information;


    public GetDataEntity(ArrayList<Results> results, Information information) {
        this.results = results;
        this.information = information;
    }

    public ArrayList<Results> getResults() {
        return results;
    }

    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public class Results implements Serializable {
        @SerializedName("gender")
        private String gender;
        @SerializedName("name")
        private Name name;
        @SerializedName("location")
        private Location location;
        @SerializedName("email")
        private String email;
        @SerializedName("picture")
        private Picture picture;
        @SerializedName("nat")
        private String nat;

        public Results(String gender, Name name, Location location, String email, Picture picture, String nat) {
            this.gender = gender;
            this.name = name;
            this.location = location;
            this.email = email;
            this.picture = picture;
            this.nat = nat;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Picture getPicture() {
            return picture;
        }

        public void setPicture(Picture picture) {
            this.picture = picture;
        }

        public String getNat() {
            return nat;
        }

        public void setNat(String nat) {
            this.nat = nat;
        }

        public class Name implements Serializable {
            @SerializedName("last")
            private String last;

            @SerializedName("title")
            private String title;

            @SerializedName("first")
            private String first;

            public Name(String last, String title, String first) {
                this.last = last;
                this.title = title;
                this.first = first;
            }

            public String getLast() {
                return last;
            }

            public void setLast(String last) {
                this.last = last;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getFirst() {
                return first;
            }

            public void setFirst(String first) {
                this.first = first;
            }
        }

        public class Location implements Serializable {
            @SerializedName("country")
            private String country;

            @SerializedName("city")
            private String city;

            @SerializedName("street")
            private Street street;

            @SerializedName("timezone")
            private Timezone timezone;

            @SerializedName("postcode")
            private String postcode;

            @SerializedName("coordinates")
            private Coordinates coordinates;

            @SerializedName("state")
            private String state;

            public Location(String country, String city, Street street, Timezone timezone, String postcode, Coordinates coordinates, String state) {
                this.country = country;
                this.city = city;
                this.street = street;
                this.timezone = timezone;
                this.postcode = postcode;
                this.coordinates = coordinates;
                this.state = state;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public Street getStreet() {
                return street;
            }

            public void setStreet(Street street) {
                this.street = street;
            }

            public Timezone getTimezone() {
                return timezone;
            }

            public void setTimezone(Timezone timezone) {
                this.timezone = timezone;
            }

            public String getPostcode() {
                return postcode;
            }

            public void setPostcode(String postcode) {
                this.postcode = postcode;
            }

            public Coordinates getCoordinates() {
                return coordinates;
            }

            public void setCoordinates(Coordinates coordinates) {
                this.coordinates = coordinates;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public class Street implements Serializable {
                @SerializedName("number")
                private Integer number;
                @SerializedName("name")
                private String name;

                public Street(Integer number, String name) {
                    this.number = number;
                    this.name = name;
                }

                public Integer getNumber() {
                    return number;
                }

                public void setNumber(Integer number) {
                    this.number = number;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }

            public class Timezone implements Serializable {
                @SerializedName("offset")
                private String offset;
                @SerializedName("description")
                private String description;

                public Timezone(String offset, String description) {
                    this.offset = offset;
                    this.description = description;
                }

                public String getOffset() {
                    return offset;
                }

                public void setOffset(String offset) {
                    this.offset = offset;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }
            }

            public class Coordinates implements Serializable {
                @SerializedName("latitude")
                private String latitude;
                @SerializedName("longitude")
                private String longitude;

                public Coordinates(String latitude, String longitude) {
                    this.latitude = latitude;
                    this.longitude = longitude;
                }

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }
            }
        }

        public class Picture implements Serializable {
            @SerializedName("thumbnail")
            private String thumbnail;

            @SerializedName("large")
            private String large;

            @SerializedName("medium")
            private String medium;

            public Picture(String thumbnail, String large, String medium) {
                this.thumbnail = thumbnail;
                this.large = large;
                this.medium = medium;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public class Information implements Serializable {
        @SerializedName("seed")
        private String seed;
        @SerializedName("results")
        private Integer results;
        @SerializedName("page")
        private Integer page;
        @SerializedName("version")
        private String version;

        public Information(String seed, Integer results, Integer page, String version) {
            this.seed = seed;
            this.results = results;
            this.page = page;
            this.version = version;
        }

        public String getSeed() {
            return seed;
        }

        public void setSeed(String seed) {
            this.seed = seed;
        }

        public Integer getResults() {
            return results;
        }

        public void setResults(Integer results) {
            this.results = results;
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}