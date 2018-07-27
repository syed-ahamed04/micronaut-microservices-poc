package pl.altkom.asc.lab.micronaut.poc.payment.infrastructure.adapters.mock;

import pl.altkom.asc.lab.micronaut.poc.payment.domain.PolicyAccount;
import pl.altkom.asc.lab.micronaut.poc.payment.domain.PolicyAccountRepository;

import javax.inject.Singleton;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Singleton
public class MockPolicyAccountRepository implements PolicyAccountRepository {

    private Map<String, PolicyAccount> policyAccountMap = init();

    private LinkedHashMap<String, PolicyAccount> init() {
        LinkedHashMap<String, PolicyAccount> map = new LinkedHashMap<>();

        map.put("PA1", new PolicyAccount("POLICY_1"));
        map.put("PA2", new PolicyAccount("POLICY_2"));
        map.put("PA3", new PolicyAccount("POLICY_3"));

        return map;
    }

    @Override
    public Optional<PolicyAccount> findForPolicy(String policyNumber) {
        return Optional.ofNullable(policyAccountMap.get(policyNumber));
    }

    @Override
    public void save(PolicyAccount policyAccount) {
        policyAccountMap.put(policyAccount.getPolicyNumber(), policyAccount);
    }

    @Override
    public Collection<PolicyAccount> findAll() {
        return policyAccountMap.values();
    }
}
