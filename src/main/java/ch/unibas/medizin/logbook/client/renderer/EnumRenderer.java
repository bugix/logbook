package ch.unibas.medizin.logbook.client.renderer;

import ch.unibas.medizin.logbook.shared.enums.Comparison;
import ch.unibas.medizin.logbook.shared.i18n.LogBookConstantsWithLookup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.text.shared.AbstractRenderer;

public class EnumRenderer<T extends Enum<?>> extends AbstractRenderer<T> {
	protected final LogBookConstantsWithLookup constants = GWT.create(LogBookConstantsWithLookup.class);
	private final Type rendererType;

	public static enum Type {
		DEFAULT, NUMERIC, LANGSKILL, ANAMNESIS, NATIONALITY, SCAR, PROFESSION, WORKPERMISSION, MARITIALSTATUS
	}

	public EnumRenderer() {
		this(Type.DEFAULT);
	}

	public EnumRenderer(Type rendererType) {
		this.rendererType = rendererType;
	}

	protected String getIdentifier(T object) {
		if (!(object instanceof Comparison) || rendererType == Type.DEFAULT) {
			return object.name();
		} else {
			return rendererType.name() + "_" + object.name();
		}
	}

	@Override
	public String render(T object) {
		if (object == null) {
			return "";
		}
		return constants.getString(getIdentifier(object));
	}

}
