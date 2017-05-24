select name, mediatypeid,
--bitnot(mediatypeid, -mediatypeid) as bitnot--,
bitand(mediatypeid, -mediatypeid) as bitand--,
--bitor(mediatypeid, -mediatypeid) as bitor--,
--bitxor(mediatypeid, mediatypeid) as bitxor--,
--bitshift(mediatypeid, 2) as bitshifBy2
from mediatype;