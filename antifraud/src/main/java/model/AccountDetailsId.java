package model;

import javax.persistence.*;

@Entity
@Table(name = "account_details_id", schema = "profile", catalog = "BANK")
public class AccountDetailsId {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "account_id")
    private Long accountId;
    @Basic
    @Column(name = "profile_id")
    private Long profileId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountDetailsId that = (AccountDetailsId) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) return false;
        if (profileId != null ? !profileId.equals(that.profileId) : that.profileId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (profileId != null ? profileId.hashCode() : 0);
        return result;
    }
}
