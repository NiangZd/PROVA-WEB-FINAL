export interface AuthResponse {
  userId?: number; // Adicione o campo userId
  redirectUrl?: string;
}
  
  export interface RegisterResponse {
    redirectUrl?: string;
  }
  
  export interface UsuarioResponseDto {
    usuarioId: number;
    name: string;
    email: string;
    isInstrutor: boolean;
    redirectUrl: string;
    password?: string; // Adicione esta propriedade se for necessário
    data_nascimento?: Date; // Adicione esta propriedade se for necessário
    data_matricula?: Date; // Adicione esta propriedade se for necessário
  }
  