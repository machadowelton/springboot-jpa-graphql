package br.com.machadowelton.services.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.machadowelton.models.Emprestimo;
import br.com.machadowelton.models.Livro;
import br.com.machadowelton.models.exception.NegocioException;
import br.com.machadowelton.services.IEmprestimoService;
import br.com.machadowelton.services.abs.SuperAbs;
import br.com.machadowelton.services.repository.EmprestimoRepository;
import br.com.machadowelton.services.repository.LivroRepository;
import br.com.machadowelton.services.repository.UsuarioRepository;

@Service
public class EmprestimoServiceImp extends SuperAbs<EmprestimoRepository> implements IEmprestimoService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	@Override
	public Emprestimo buscarPorIdEIdUsuario(Long id, Long IdUsuario) {
		return repository.findByIdAndUsuarioId(id, IdUsuario)
				.map( e -> {
					return e;
				}).orElseThrow(() -> new NegocioException("Nenhum emprestimo encontrado pelo id: " + id + " e idUsuario: " + IdUsuario));
	}

	@Override
	public List<Emprestimo> listarPorIdUsuarioPaginado(Long idUsuario, Pageable pageable) {
		List<Emprestimo> emprestimos = repository.findByUsuarioId(idUsuario, pageable)
											.get()
											.collect(Collectors.toList());
		if(emprestimos.size() < 1)
			throw new NegocioException("Nenhum emprestimo encontrado");
		return emprestimos;
	}

	@Override
	public List<Emprestimo> listarTodosPaginado(Pageable pageable) {
		List<Emprestimo> emprestimos = repository.findAll(pageable)
				.get()
				.collect(Collectors.toList());
		if(emprestimos.size() < 1)
			throw new NegocioException("Nenhum emprestimo encontrado");
		return emprestimos;
	}

	@Override
	public Emprestimo inserir(Long idUsuario, Emprestimo emprestimo) {
		Emprestimo emp = usuarioRepository.findById(idUsuario)
							.map( u -> {
								emprestimo.setUsuario(u);
								return repository.save(emprestimo);
							}).orElseThrow(() -> new NegocioException("Nenhum usuário encontrado pelo id: " + idUsuario));
		return emp;
	}

	@Override
	public Emprestimo atualizar(Long idUsuario, Emprestimo emprestimo) {
		if(!repository.existsByIdAndUsuarioId(emprestimo.getId(), idUsuario))
			throw new NegocioException("Nenhum emprestimo encontrado com id: " + emprestimo.getId() + " e idUsuario: " + idUsuario);
		return repository.save(emprestimo);
	}

	@Override
	public void deletarPorIdEIdUsuario(Long id, Long idUsuario) {
		if(!repository.existsByIdAndUsuarioId(id, idUsuario))
			throw new NegocioException("Nenhum emprestimo encontrado com id: " + id + " e idUsuario: " + idUsuario);
		repository.deleteById(id);
	}

	@Override
	public void addLivro(Long idUsuario, Long idEmprestimo, Long idLivro) {
		if(!repository.existsByIdAndUsuarioId(idEmprestimo, idUsuario))
			throw new NegocioException("Nenhum emprestimo encontrado com id: " + idEmprestimo + " e idUsuario: " + idUsuario);
		repository.findById(idEmprestimo)
			.map( emprestimo -> {
				Livro livro = livroRepository.findById(idLivro)
						.map( l -> {
							l.getEmprestimos().add(emprestimo);
							return l;
						}).orElseThrow(() -> new NegocioException("Nenhum livro encontrado pelo id: " + idLivro));
				emprestimo.getLivros().add(livro);
				return repository.save(emprestimo);
			}).orElseThrow(() -> new NegocioException("Nenhum emprestimo encontrado pelo id: " + idEmprestimo));
	}

}
