package ch.unibas.medizin.logbook.client.ui;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.google.gwt.user.cellview.client.CellTable;

public interface MyCellTableResources extends CellTable.Resources {

	public interface Style extends CellTable.Style {
		String cellTableEvenYesRow();

		String cellTableOddYesRow();

		String cellTableEvenNoRow();

		String cellTableOddNoRow();
	}

	@Override
	@Source({ CellTable.Style.DEFAULT_CSS, "MyCellTable.css" })
	Style cellTableStyle();

	@Override
	@Source("ui-bg_gloss-wave_75_2191c0_500x100.png")
	@ImageOptions(repeatStyle = RepeatStyle.Horizontal, flipRtl = true, width = 180)
	ImageResource cellTableHeaderBackground();

	@Override
	@Source("ui-bg_gloss-wave_75_2191c0_500x100.png")
	@ImageOptions(repeatStyle = RepeatStyle.Horizontal, flipRtl = true)
	ImageResource cellTableSelectedBackground();

}
