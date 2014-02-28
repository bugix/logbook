package ch.unibas.medizin.logbook.client.resources;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.SimplePager;

public interface MySimplePagerResources extends SimplePager.Resources {
	@Override
	@Source("MySimplePager.css")
	SimplePager.Style simplePagerStyle();

	@Override
	@Source("images/fastForward.png")
	ImageResource simplePagerFastForward();

	@Override
	@Source("images/fastForwardDisabled.png")
	ImageResource simplePagerFastForwardDisabled();

	@Override
	@Source("images/jumpStart.png")
	ImageResource simplePagerFirstPage();

	@Override
	@Source("images/jumpStartDisabled.png")
	ImageResource simplePagerFirstPageDisabled();

	@Override
	@Source("images/jumpEnd.png")
	ImageResource simplePagerLastPage();

	@Override
	@Source("images/jumpEndDisabled.png")
	ImageResource simplePagerLastPageDisabled();

	@Override
	@Source("images/forward.png")
	ImageResource simplePagerNextPage();

	@Override
	@Source("images/forwardDisabled.png")
	ImageResource simplePagerNextPageDisabled();

	@Override
	@Source("images/back.png")
	ImageResource simplePagerPreviousPage();

	@Override
	@Source("images/backDisabled.png")
	ImageResource simplePagerPreviousPageDisabled();
}
