public enum Country {
  ONE(1,"你"),
  TWO(2,"好"),
  THREE(3,"朋"),
  FOUR(4,"友");
  // 属性注释
  private Integer retCode;
  private String retMessage;
  CountryEnum(Integer retCode, String retMessage) {
    this.retCode = retCode;
    this.retMessage = retMessage;
  }
  //方法注释
  public static CountryEnum FOREACH_ENMU(int index){
    CountryEnum[] values = CountryEnum.values();
    for (CountryEnum value : values) {
      if (index == value.getRetCode()) {
        return value;
      }
    }
    return null;
  }
  public Integer getRetCode() {
    return retCode;
  }
  public void setRetCode(Integer retCode) {
    this.retCode = retCode;
  }
  public String getRetMessage() {
    return retMessage;
  }
  public void setRetMessage(String retMessage) {
    this.retMessage = retMessage;
  }
}
