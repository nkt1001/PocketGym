class FilterAdapter implements Processor {
	Filter filter;
	public FilterAdapter(Filter f) {
		// TODO Auto-generated constructor stub
		filter = f;
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return filter.name();
	}

	@Override
	public Waveform process(Object obj) {
		// TODO Auto-generated method stub
		return filter.process((Waveform)obj);
	}

}

