package model.company;

import java.util.ArrayList;
import java.util.List;

public class CompanyCatalog {
	private List<Company> companies;

    public CompanyCatalog() {
        this.companies = new ArrayList<>();
    }

    public void addCompany(Company company) {
        companies.add(company);
    }

    public Company findCompanyByName(String name) {
        for (Company company : companies) {
            if (company.getCompanyName().equals(name)) {
                return company;
            }
        }
        return null; 
    }

    public void updateCompany(Company company) {
    	for(int i = 0; i < companies.size(); i++){
    		if(companies.get(i).getCompanyId().equals(company.getCompanyId())) {
    			companies.set(i, company);
    			break;
    		}
    	
    	}
       
    }

    public void deleteCompany(Company company) {
        companies.remove(company);
    }

    public int countCompany() {
        return companies.size();
    }

//    public int countApplicationByCompany(Company company) {
//    	int count = 0;
//    	for(Company c : companies) {
//    		if(c.getCompanyName().equals(company.getCompanyName())) {
//    			count+= c.getJobCatalog().countApplications();
//    		}
//    	}
//    	return count;
//    }
}
