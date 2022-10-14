package health_declaration.repository;

import health_declaration.model.HealthDeclaration;

import java.util.ArrayList;
import java.util.List;

public class HealthDeclarationRepoImpl implements HealthDeclarationRepo {
    private List<HealthDeclaration> list = new ArrayList<>();
    @Override
    public void save(HealthDeclaration healthDeclaration) {
         list.add(healthDeclaration);
    }

    @Override
    public HealthDeclaration getHealthDeclarationByIdCard(String idCard) {
        for(HealthDeclaration healthDeclaration : list) {
            if(healthDeclaration.getIdCardNumber().equals(idCard)) {
                return healthDeclaration;
            }
        }
        return null;
    }
}
