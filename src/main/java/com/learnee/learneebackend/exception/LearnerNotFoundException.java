package com.learnee.learneebackend.exception;

public class LearnerNotFoundException extends RuntimeException {
    public LearnerNotFoundException(Long id) { super("L'apprenant possédant l'id" + id + "n'a pas été trouvé.");}
}
