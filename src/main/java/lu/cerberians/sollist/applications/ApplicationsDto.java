package lu.cerberians.sollist.applications;

public class ApplicationsDto {

    private int sollId;
    private int appId;
    private int assetId;
    private String application;
    private String assetName;
    private String assetType;
    private String assetOwner;
    private String businessRole;
    private boolean soll;
    private boolean sollist;

    public ApplicationsDto(int sollId, int appId, int assetId, String application, String assetName, String assetType, String assetOwner, String businessRole, boolean soll, boolean sollist) {
        this.sollId = sollId;
        this.appId = appId;
        this.assetId = assetId;
        this.sollId = sollId;
        this.application = application;
        this.assetName = assetName;
        this.assetType = assetType;
        this.assetOwner = assetOwner;
        this.businessRole = businessRole;
        this.soll = soll;
        this.sollist = sollist;
    }

    public ApplicationsDto() {
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetOwner() {
        return assetOwner;
    }

    public void setAssetOwner(String assetOwner) {
        this.assetOwner = assetOwner;
    }

    public String getBusinessRole() {
        return businessRole;
    }

    public void setBusinessRole(String businessRole) {
        this.businessRole = businessRole;
    }

    public boolean isSoll() {
        return soll;
    }

    public void setSoll(boolean soll) {
        this.soll = soll;
    }

    public boolean isSollist() {
        return sollist;
    }

    public void setSollist(boolean sollist) {
        this.sollist = sollist;
    }

    public int getSollId() {
        return sollId;
    }

    public void setSollId(int sollId) {
        this.sollId = sollId;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }
}

