class FriendBirthday {
    private String birthDate;
    private String name;
    public FriendBirthday(){

    }
    public FriendBirthday(String birthDate, String name){
        this.birthDate = birthDate;
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
