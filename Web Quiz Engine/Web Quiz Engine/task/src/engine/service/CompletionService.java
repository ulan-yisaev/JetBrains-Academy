package engine.service;

import engine.dto.CompletionDto;
import engine.mapper.CompletionMapper;
import engine.repository.CompletionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompletionService {
    private final CompletionRepository completionRepository;
    private final CompletionMapper completionMapper;

    public CompletionService(CompletionRepository completionRepository, CompletionMapper completionMapper) {
        this.completionRepository = completionRepository;
        this.completionMapper = completionMapper;
    }

    public Page<CompletionDto> findUserCompletions(int page, int pageSize, String email) {
        Pageable paging = PageRequest.of(page, pageSize); //, Sort.by("completedAt").descending());
        return completionRepository.getCompletionsByUser(email, paging)
                .map(completionMapper::toCompletionDto);
    }
}