package org.apereo.cas.audit.spi.config;

import org.apereo.inspektr.audit.annotation.Audit;
import org.apereo.inspektr.audit.spi.support.AbstractSuffixAwareAuditActionResolver;
import org.aspectj.lang.JoinPoint;

/**
 * @author: wangsaichao
 * @date: 2018/8/10
 * @description:
 */
public class DeleteServiceActionResolver extends AbstractSuffixAwareAuditActionResolver {

    /**
     * Constructs the resolver with empty values for the two suffixes.
     */
    public DeleteServiceActionResolver() {
        this("","");
    }

    /**
     * Constructs the {@link DeleteServiceActionResolver} with a success suffix and failure
     * suffix.  CANNOT be NULL.
     * @param successSuffix the suffix to use in the event of a success.
     * @param failureSuffix the suffix to use in the event of a failure.
     */
    public DeleteServiceActionResolver(final String successSuffix, final String failureSuffix) {
        super(successSuffix, failureSuffix);
    }

    @Override
    public String resolveFrom(final JoinPoint auditableTarget, final Object retval, final Audit audit) {
        return audit.action() + getSuccessSuffix();
    }

    @Override
    public String resolveFrom(final JoinPoint auditableTarget, final Exception exception, final Audit audit) {
        return audit.action() + getFailureSuffix();
    }

}
