package FinalTest.zavrsniback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Format;
import FinalTest.zavrsniback.web.dto.FormatDTO;

@Component
public class FormatToFormatDTO implements Converter<Format, FormatDTO> {

	@Override
	public FormatDTO convert(Format format) {
		FormatDTO formatDTO = new FormatDTO();

		formatDTO.setId(format.getId());
		formatDTO.setTip(format.getTip());
		formatDTO.setBrojUcesnika(format.getBrojUcesnika());

		return formatDTO;
	}

	public List<FormatDTO> convert(List<Format> formati) {
		List<FormatDTO> formatDTOS = new ArrayList<>();

		for (Format format : formati) {
			formatDTOS.add(convert(format));
		}
		return formatDTOS;
	}
}
