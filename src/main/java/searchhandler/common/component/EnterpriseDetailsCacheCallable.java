package searchhandler.common.component;

import searchhandler.common.EnterpriseCache;
import searchhandler.common.EnterpriseQueue;
import searchhandler.common.utils.DataUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Slf4j
@Component
@SuppressWarnings({"unchecked"})
public class EnterpriseDetailsCacheCallable extends FullDetailsCacheCallable {

    public EnterpriseDetailsCacheCallable(List dataList) {
        super(dataList);
    }

    @Override
    protected Consumer<Object> getListGenerator() {
        return (x) -> {
            Map data = (Map) x;
            String enterprise_name = ((String) data.get("enterprise_name")).trim();
            Map trgt = new HashMap();
            trgt.put("registration_authority", data.get("registration_authority"));
            trgt.put("business_time_start", data.get("business_time_start"));
            trgt.put("registration_status", data.get("registration_status"));
            trgt.put("credit_code", data.get("credit_code"));
            trgt.put("residence", data.get("residence"));
            trgt.put("approval_date", data.get("approval_date"));
            trgt.put("charge_person", data.get("charge_person"));
            trgt.put("business_time_end", data.get("business_time_end"));
            trgt.put("establishment_date", data.get("establishment_date"));
            trgt.put("province_name", data.get("province_name"));
            trgt.put("province_code", data.get("province_code"));
            trgt.put("registration_no", data.get("registration_no"));
            trgt.put("registered_capital_origin", data.get("registered_capital_origin"));
            trgt.put("business_scope", data.get("business_scope"));
            trgt.put("enterprises_type", data.get("enterprises_type"));
            trgt.put("enterprise_name", enterprise_name);

            List<Map> share = DataUtils.getNotNullValue(data, "shareholder_information", List.class, new ArrayList<>());
            List trgtShare = share.stream().map(y -> {
                String shareholder_type = DataUtils.getNotNullValue(y, "shareholder_type", String.class, "");
                if (!"自然人股东".equals(shareholder_type)) {
                    String shareholder_name = DataUtils.getNotNullValue(y, "shareholder_name", String.class, "");
                    if (StringUtils.isNotBlank(shareholder_name) && EnterpriseQueue.recordName(shareholder_name)) {
                        additionalSet.add(shareholder_name);
                        EnterpriseCache.append(shareholder_name, enterprise_name);
                        return shareholder_name;
                    }
                }
                return "";
            }).filter(StringUtils::isNotBlank).collect(Collectors.toList());
            trgt.put("shareholder_information", trgtShare);
            EnterpriseCache.put(enterprise_name, trgt);
        };
    }
}
