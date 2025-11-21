// Função para aplicar máscara de CPF
function maskCpf(input) {
    let value = input.value.replace(/\D/g, ''); // Remove tudo que não for dígito
    value = value.replace(/(\d{3})(\d)/, '$1.$2');
    value = value.replace(/(\d{3})(\d)/, '$1.$2');
    value = value.replace(/(\d{3})(\d{1,2})$/, '$1-$2');
    input.value = value;
}

// Função para aplicar máscara de telefone (com 8 ou 9 dígitos no final)
// Ex: (XX) XXXXX-XXXX ou (XX) XXXX-XXXX
function maskPhone(input) {
    let value = input.value.replace(/\D/g, ''); // Remove tudo que não for dígito
    if (value.length > 10) { // Para números com 9 dígitos (celular)
        value = value.replace(/^(\d\d)(\d{5})(\d{4}).*/, '($1) $2-$3');
    } else if (value.length > 2) { // Para números com 8 dígitos (fixo) ou apenas DDD
        value = value.replace(/^(\d\d)(\d)/, '($1) $2');
    } else { // Menos de 2 dígitos
        value = value.replace(/^(\d*)/, '($1');
    }
    input.value = value;
}

// Função para aplicar máscara de CEP
function maskCep(input) {
    let value = input.value.replace(/\D/g, ''); // Remove tudo que não for dígito
    value = value.replace(/^(\d{5})(\d)/, '$1-$2');
    input.value = value;
}

// Função para preencher endereço automaticamente usando ViaCEP
function preencherEndereco(cepInput) {
    let cep = cepInput.value.replace(/\D/g, ''); // Remove a máscara
    if (cep.length !== 8) {
        return;
    }

    // URL da API ViaCEP
    const url = `https://viacep.com.br/ws/${cep}/json/`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            if (!data.erro) {
                // Preenche os campos de endereço e estado
                document.getElementById('endereco').value = `${data.logradouro}, ${data.bairro}`;
                document.getElementById('estado').value = data.uf;
                // Foca no campo de número para o usuário completar
                document.getElementById('numero').focus();
            } else {
                console.error("CEP não encontrado.");
                // Opcional: Limpar campos ou mostrar mensagem de erro
            }
        })
        .catch(error => {
            console.error("Erro ao buscar CEP:", error);
        });
}

// Adicionar event listeners aos campos de formulário que precisam de máscara
document.addEventListener('DOMContentLoaded', () => {
    // Máscara de CPF
    const cpfInput = document.getElementById('cpf');
    if (cpfInput) {
        cpfInput.addEventListener('input', () => maskCpf(cpfInput));
    }

    // Máscara de Telefone
    const telefoneInput = document.getElementById('telefone');
    if (telefoneInput) {
        telefoneInput.addEventListener('input', () => maskPhone(telefoneInput));
    }

    // Máscara de CEP e preenchimento automático
    const cepInput = document.getElementById('cep');
    if (cepInput) {
        cepInput.addEventListener('input', () => maskCep(cepInput));
        // Dispara o preenchimento ao perder o foco (onblur)
        cepInput.addEventListener('blur', () => preencherEndereco(cepInput));
    }
});
