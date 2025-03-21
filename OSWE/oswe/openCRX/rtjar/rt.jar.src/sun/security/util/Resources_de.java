/*     */ package sun.security.util;
/*     */ 
/*     */ import java.util.ListResourceBundle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Resources_de
/*     */   extends ListResourceBundle
/*     */ {
/*  35 */   private static final Object[][] contents = new Object[][] { { "invalid.null.input.s.", "Ungültige Nulleingabe(n)" }, { "actions.can.only.be.read.", "Aktionen können nur \"lesen\" sein" }, { "permission.name.name.syntax.invalid.", "Syntax für Berechtigungsnamen [{0}] ungültig: " }, { "Credential.Class.not.followed.by.a.Principal.Class.and.Name", "Nach Zugangsdatenklasse folgt keine Principal-Klasse und kein Name" }, { "Principal.Class.not.followed.by.a.Principal.Name", "Nach Principal-Klasse folgt kein Principal-Name" }, { "Principal.Name.must.be.surrounded.by.quotes", "Principal-Name muss in Anführungszeichen stehen" }, { "Principal.Name.missing.end.quote", "Abschließendes Anführungszeichen für Principal-Name fehlt" }, { "PrivateCredentialPermission.Principal.Class.can.not.be.a.wildcard.value.if.Principal.Name.is.not.a.wildcard.value", "Principal-Klasse PrivateCredentialPermission kann kein Platzhalterwert (*) sein, wenn der Principal-Name kein Platzhalterwert (*) ist" }, { "CredOwner.Principal.Class.class.Principal.Name.name", "CredOwner:\n\tPrincipal-Klasse = {0}\n\tPrincipal-Name = {1}" }, { "provided.null.name", "Nullname angegeben" }, { "provided.null.keyword.map", "Null-Schlüsselwortzuordnung angegeben" }, { "provided.null.OID.map", "Null-OID-Zuordnung angegeben" }, { "NEWLINE", "\n" }, { "invalid.null.AccessControlContext.provided", "Ungültiger Nullwert für AccessControlContext angegeben" }, { "invalid.null.action.provided", "Ungültige Nullaktion angegeben" }, { "invalid.null.Class.provided", "Ungültige Nullklasse angegeben" }, { "Subject.", "Subjekt:\n" }, { ".Principal.", "\tPrincipal: " }, { ".Public.Credential.", "\tÖffentliche Zugangsdaten: " }, { ".Private.Credentials.inaccessible.", "\tKein Zugriff auf private Zugangsdaten\n" }, { ".Private.Credential.", "\tPrivate Zugangsdaten: " }, { ".Private.Credential.inaccessible.", "\tKein Zugriff auf private Zugangsdaten\n" }, { "Subject.is.read.only", "Subjekt ist schreibgeschützt" }, { "attempting.to.add.an.object.which.is.not.an.instance.of.java.security.Principal.to.a.Subject.s.Principal.Set", "Es wird versucht, ein Objekt hinzuzufügen, das keine Instanz von java.security.Principal für eine Principal-Gruppe eines Subjekts ist" }, { "attempting.to.add.an.object.which.is.not.an.instance.of.class", "Es wird versucht, ein Objekt hinzuzufügen, das keine Instanz von {0} ist" }, { "LoginModuleControlFlag.", "LoginModuleControlFlag: " }, { "Invalid.null.input.name", "Ungültige Nulleingabe: Name" }, { "No.LoginModules.configured.for.name", "Für {0} sind keine LoginModules konfiguriert" }, { "invalid.null.Subject.provided", "Ungültiges Nullsubjekt angegeben" }, { "invalid.null.CallbackHandler.provided", "Ungültiger Nullwert für CallbackHandler angegeben" }, { "null.subject.logout.called.before.login", "Nullsubjekt - Abmeldung vor Anmeldung aufgerufen" }, { "unable.to.instantiate.LoginModule.module.because.it.does.not.provide.a.no.argument.constructor", "LoginModule {0} kann nicht instanziiert werden, da es keinen argumentlosen Constructor angibt" }, { "unable.to.instantiate.LoginModule", "LoginModule kann nicht instanziiert werden" }, { "unable.to.instantiate.LoginModule.", "LoginModule kann nicht instanziiert werden: " }, { "unable.to.find.LoginModule.class.", "LoginModule-Klasse kann nicht gefunden werden: " }, { "unable.to.access.LoginModule.", "Kein Zugriff auf LoginModule möglich: " }, { "Login.Failure.all.modules.ignored", "Anmeldefehler: Alle Module werden ignoriert" }, { "java.security.policy.error.parsing.policy.message", "java.security.policy: Fehler beim Parsen von {0}:\n\t{1}" }, { "java.security.policy.error.adding.Permission.perm.message", "java.security.policy: Fehler beim Hinzufügen von Berechtigung, {0}:\n\t{1}" }, { "java.security.policy.error.adding.Entry.message", "java.security.policy: Fehler beim Hinzufügen von Eintrag:\n\t{0}" }, { "alias.name.not.provided.pe.name.", "Aliasname nicht angegeben ({0})" }, { "unable.to.perform.substitution.on.alias.suffix", "Substitution für Alias {0} kann nicht ausgeführt werden" }, { "substitution.value.prefix.unsupported", "Substitutionswert {0} nicht unterstützt" }, { "LPARAM", "(" }, { "RPARAM", ")" }, { "type.can.t.be.null", "Typ kann nicht null sein" }, { "keystorePasswordURL.can.not.be.specified.without.also.specifying.keystore", "keystorePasswordURL kann nicht ohne Keystore angegeben werden" }, { "expected.keystore.type", "Keystore-Typ erwartet" }, { "expected.keystore.provider", "Keystore-Provider erwartet" }, { "multiple.Codebase.expressions", "mehrere Codebase-Ausdrücke" }, { "multiple.SignedBy.expressions", "mehrere SignedBy-Ausdrücke" }, { "duplicate.keystore.domain.name", "Keystore-Domainname doppelt vorhanden: {0}" }, { "duplicate.keystore.name", "Keystore-Name doppelt vorhanden: {0}" }, { "SignedBy.has.empty.alias", "Leerer Alias in SignedBy" }, { "can.not.specify.Principal.with.a.wildcard.class.without.a.wildcard.name", "Principal kann nicht mit einer Platzhalterklasse ohne Platzhalternamen angegeben werden" }, { "expected.codeBase.or.SignedBy.or.Principal", "codeBase oder SignedBy oder Principal erwartet" }, { "expected.permission.entry", "Berechtigungseintrag erwartet" }, { "number.", "Nummer " }, { "expected.expect.read.end.of.file.", "[{0}] erwartet, [Dateiende] gelesen" }, { "expected.read.end.of.file.", "[;] erwartet, [Dateiende] gelesen" }, { "line.number.msg", "Zeile {0}: {1}" }, { "line.number.expected.expect.found.actual.", "Zeile {0}: [{1}] erwartet, [{2}] gefunden" }, { "null.principalClass.or.principalName", "principalClass oder principalName null" }, { "PKCS11.Token.providerName.Password.", "Kennwort für PKCS11-Token [{0}]: " }, { "unable.to.instantiate.Subject.based.policy", "Subjektbasierte Policy kann nicht instanziiert werden" } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[][] getContents() {
/* 169 */     return contents;
/*     */   }
/*     */ }


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/sun/security/util/Resources_de.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */