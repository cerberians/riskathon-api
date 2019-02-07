package lu.cerberians.sollist.forms;

import java.util.Arrays;
import java.util.List;

public class ApplicationListForm {

    private List<ApplicationsForm> applications;

    public ApplicationListForm() {
        this.applications = Arrays.asList(
new ApplicationsForm(1,1,1,"Dovetail", "database", "data server", "Asset owner 1","","",true, false),
new ApplicationsForm(2,1,1,"Dovetail", "server1", "application server 1", "Asset owner 2","","",false,true),
new ApplicationsForm(3,1,1,"Dovetail", "server2", "application server 2", "Asset owner 3","","BR3",false, true)
);
    }

    public List<ApplicationsForm> getApplications() {
        return applications;
    }

    public void setApplications(List<ApplicationsForm> applications) {
        this.applications = applications;
    }

    public class ApplicationsForm {

        private int sollId;
        private int appId;
        private int assetId;
        private String application;
        private String assetName;
        private String assetType;
        private String assetOwner;
        private String itCustodian;
        private String businessRole;
        private boolean soll;
        private boolean sollist;

        public ApplicationsForm(int sollId,int appId,int assetId,String application, String assetName, String assetType, String assetOwner, String itCustodian, String businessRole, boolean soll, boolean sollist) {
            this.sollId = sollId;
            this.appId = appId;
            this.assetId = assetId;
            this.sollId = sollId;
            this.application = application;
            this.assetName = assetName;
            this.assetType = assetType;
            this.assetOwner = assetOwner;
            this.itCustodian = itCustodian;
            this.businessRole = businessRole;
            this.soll = soll;
            this.sollist = sollist;
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

        public String getItCustodian() {
            return itCustodian;
        }

        public void setItCustodian(String itCustodian) {
            this.itCustodian = itCustodian;
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
}
