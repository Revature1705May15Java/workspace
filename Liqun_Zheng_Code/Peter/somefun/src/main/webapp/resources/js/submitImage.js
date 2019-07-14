function findImageBlob(parent, tagname)
{
	$("#blob").val($('#'+parent+' '+tagname)[0]['currentSrc']);
}