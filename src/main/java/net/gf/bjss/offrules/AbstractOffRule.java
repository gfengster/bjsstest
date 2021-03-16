package net.gf.bjss.offrules;

import java.io.PrintStream;
import java.util.List;

import net.gf.bjss.utils.PriceHelper;

abstract class AbstractOffRule implements OffRule {
	protected final String desc;
	
	AbstractOffRule(String desc) {
		this.desc = desc;
	}
	
	protected void printDiscount(float discount, List<PrintStream> out) {
		if (discount != 0) {
			for (PrintStream ps : out)
				ps.println(desc + "\t-" + PriceHelper.getPrintFormat(discount));
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final AbstractOffRule other = (AbstractOffRule) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		return true;
	}
}
