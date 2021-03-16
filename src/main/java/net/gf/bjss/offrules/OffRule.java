package net.gf.bjss.offrules;

import java.io.PrintStream;
import java.util.List;

import net.gf.bjss.good.Item;

public interface OffRule {
	public float calculateOff(List<Item> purchases, List<PrintStream> out);
}
